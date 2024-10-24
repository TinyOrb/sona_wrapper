#!/bin/bash

p_root="$(dirname $(dirname $(readlink -f $0 )))"
dfile="${p_root}/Dockerfile"


if [ ! -f "${dfile}" ]; then 
    echo "dockerfile not found at ${dfile}"
    exit -1
fi

cd ${p_root}

image_name="sona_wrapper"
image_version="latest"
service_name="sona_wrapper"
deploy_version="deploy"

docker stop ${service_name} || true
docker rm ${service_name} || true
docker image rm  ${image_name}:${deploy_version} || true
docker image rm "${image_name}:${image_version}" || true
docker build -t "${image_name}:${image_version}" .


docker run --name "${service_name}" --mount type=bind,source="${p_root}/src",target="/opt/app/src" \
--entrypoint "/bin/bash" ${image_name}:${image_version} -c "cd /opt/app && mvn clean"

docker cp resources/docker/maven/settings.xml "${service_name}:/root/.m2"
docker cp resources/.gnupg "${service_name}:/root"
docker cp resources/docker/maven/central-pom.xml "${service_name}:/opt/app/pom.xml"
docker commit ${service_name} ${image_name}:${deploy_version}

docker stop ${service_name} || true
docker rm ${service_name} || true

docker run --name "${service_name}" --mount type=bind,source="${p_root}/src",target="/opt/app/src" \
 --entrypoint "/bin/bash" ${image_name}:${deploy_version} -c "chown -R root /root/.gnupg && cd /opt/app && \
  mvn --settings /root/.m2/settings.xml clean deploy"
# gpg --list-keys"
#  mvn --settings /root/.m2/settings.xml clean package deploy"

