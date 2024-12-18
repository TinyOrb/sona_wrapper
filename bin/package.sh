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

docker stop ${service_name} || true
docker rm ${service_name} || true

docker image rm "${image_name}:${image_version}" || true
docker build -t "${image_name}:${image_version}" .


docker run --name "${service_name}" --mount type=bind,source="${p_root}/src",target="/opt/app/src" \
--mount type=bind,source="${p_root}/.m2",target="/root/.m2" \
--entrypoint "/bin/bash" ${image_name}:${image_version} \
-c "cd /opt/app && mvn clean compile && mvn package"


# -c "export PATH=$PATH:${JAVA_HOME}/bin && cd /opt/app && javac -cp /root/.m2/repository/* src/main/org/tinyorb/sona/sona_wrapper/*.java && jar cvf /opt/app/target/mylib.jar org/**/*.class"
# -c "cd /opt/app && mvn clean install && cp -r /root/.m2/repository/org/tinyorb/sona/sona_wrapper /opt/app/target/"

docker cp "${service_name}:/opt/app/target" .

