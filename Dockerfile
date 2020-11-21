FROM ubuntu:18.04

WORKDIR sharing

COPY src/SharingNotes sharing

RUN  apt-get update && apt-get install -y curl gnupg && \
  echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list && \
  curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add && \
  apt-get update && \
  apt-get install -y sbt openjdk-11-jdk

CMD cd sharing && sbt test
