FROM python:3.9-alpine

RUN apk update && apk add socat

RUN adduser -D -u 1001 -s /bin/bash ctf

RUN mkdir /home/ctf/chall

COPY ./requirements.txt /home/ctf/chall
RUN pip3 install -r /home/ctf/chall/requirements.txt

RUN mkdir /home/ctf/chall/src

COPY ./chall.py /home/ctf/chall/src
COPY ./run.sh /home/ctf/chall/src
COPY ./flag.txt /home/ctf/chall/src

RUN chown -R root:root /home/ctf/chall
RUN chmod -R 555 /home/ctf/chall
USER ctf
WORKDIR /home/ctf/chall/src

CMD ["sh", "./run.sh"]

# RSCTF dynamic-flag compatibility layer. The build-time scan records
# exact marker-bearing files; runtime replacement is therefore bounded
# to those files instead of walking the image on every team start.
USER root
COPY rsctf-entrypoint.sh /usr/local/bin/rsctf-entrypoint
RUN set -eu; \
    chmod 0555 /usr/local/bin/rsctf-entrypoint; \
    : > /etc/rsctf-flag-targets; \
    for root in /home/ctf/chall /home/ctf/chall/src /app /src /srv /home /opt /var/www /challenge /chall /ctf /root /usr/src /usr/local/bin /workspace /flag /flag.txt; do \
      if [ -e "$root" ]; then \
        find "$root" -xdev -type f ! -path /usr/local/bin/rsctf-entrypoint -exec grep -lF -e RSCTF_DYNAMIC_FLAG_e39c2dc5cca4f6db31198b9a967f7769 -e RSCTF_DYNAMIC_FLAG_e97293085fa31dd5f7271dd {} + >> /etc/rsctf-flag-targets 2>/dev/null || true; \
      fi; \
    done; \
    sort -u /etc/rsctf-flag-targets > /etc/rsctf-flag-targets.sorted; \
    mv /etc/rsctf-flag-targets.sorted /etc/rsctf-flag-targets; \
    while IFS= read -r target; do [ -f "$target" ] && chmod a+w "$target"; done < /etc/rsctf-flag-targets
USER ctf
ENTRYPOINT ["/usr/local/bin/rsctf-entrypoint"]
