FROM python:alpine

RUN pip3 install requests flask gunicorn

WORKDIR /app
COPY app.py ./app.py

USER 1001

ENV FLAG "RSCTF_DYNAMIC_FLAG_e66a3154c626d0b1feb7d7c3d71bae4bf"

CMD [ "sh", "-c", "python3 -m gunicorn --bind 0.0.0.0:8080 -w 8 app:app" ]

# RSCTF dynamic-flag compatibility layer. The build-time scan records
# exact marker-bearing files; runtime replacement is therefore bounded
# to those files instead of walking the image on every team start.
USER root
COPY rsctf-entrypoint.sh /usr/local/bin/rsctf-entrypoint
RUN set -eu; \
    chmod 0555 /usr/local/bin/rsctf-entrypoint; \
    : > /etc/rsctf-flag-targets; \
    for root in /app/app.py /app /src /srv /home /opt /var/www /challenge /chall /ctf /root /usr/src /usr/local/bin /workspace /flag /flag.txt; do \
      if [ -e "$root" ]; then \
        find "$root" -xdev -type f ! -path /usr/local/bin/rsctf-entrypoint -exec grep -lF -e RSCTF_DYNAMIC_FLAG_e66a3154c626d0b1feb7d7c3d71bae4bf -e RSCTF_DYNAMIC_FLAG_8a23925f6266c1c073f03bbc {} + >> /etc/rsctf-flag-targets 2>/dev/null || true; \
      fi; \
    done; \
    sort -u /etc/rsctf-flag-targets > /etc/rsctf-flag-targets.sorted; \
    mv /etc/rsctf-flag-targets.sorted /etc/rsctf-flag-targets; \
    while IFS= read -r target; do [ -f "$target" ] && chmod a+w "$target"; done < /etc/rsctf-flag-targets
USER 1001
ENTRYPOINT ["/usr/local/bin/rsctf-entrypoint"]
