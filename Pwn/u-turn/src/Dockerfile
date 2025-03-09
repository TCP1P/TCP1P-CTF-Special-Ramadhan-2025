FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y --no-install-recommends socat

RUN rm -rf /var/lib/apt/lists/*
RUN     useradd ctf
WORKDIR /home/ctf

COPY ./chall /home/ctf/
COPY ./flag.txt /home/ctf/

RUN chown -R root:root  /home/ctf
RUN chmod -R 755        /home/ctf

EXPOSE 8888
ENTRYPOINT ["socat", "TCP-LISTEN:8888,reuseaddr,fork,nodelay,su=ctf", "EXEC:'timeout 60 ./chall'"]
