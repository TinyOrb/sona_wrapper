#!/bin/bash

dfile="$(dirname $(dirname $(readlink -f $0 )))/Dockerfile"

if [ ! -f "${dfile}" ]; then 
    echo "dockerfile not found at ${dfile}"
    exit -1
fi

cd ${dfile}

image_name="sona_wrapper"
image_version="latest"
service_name="sona_wrapper"

docker build -t "${image_name}:${version}" .

docker run -d --name "sona_wrapper" --entrypoint "/bin/bash" ${image_name}:${version} \
-c "maven clean build"