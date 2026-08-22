FROM dimasmaualana/solana:latest

WORKDIR /home/ctf/
COPY ./setup/package.json ./setup/package.json
RUN cd setup && yarn
COPY ./setup/ /home/ctf/setup/
RUN cd setup && anchor keys sync && anchor build
COPY ./deploy/ /home/ctf/
RUN solana-keygen new --no-passphrase -o /root/.config/solana/id.json --force
RUN solana config set -k /root/.config/solana/id.json
COPY ./tests/* /home/ctf/setup/tests/

# RSCTF dynamic-flag compatibility layer. The build-time scan records
# exact marker-bearing files; runtime replacement is therefore bounded
# to those files instead of walking the image on every team start.
USER root
COPY rsctf-entrypoint.sh /usr/local/bin/rsctf-entrypoint
RUN set -eu; \
    chmod 0555 /usr/local/bin/rsctf-entrypoint; \
    : > /etc/rsctf-flag-targets; \
    for root in /home/ctf/setup/tests /home/ctf /home/ctf/setup /home/ctf/setup/package.json /home/ctf/ /app /src /srv /home /opt /var/www /challenge /chall /ctf /root /usr/src /usr/local/bin /workspace /flag /flag.txt; do \
      if [ -e "$root" ]; then \
        find "$root" -xdev -type f ! -path /usr/local/bin/rsctf-entrypoint -exec grep -lF -e RSCTF_DYNAMIC_FLAG_801ddbaaa2cfeeda1b84f2fcf7c5fffd3 -e RSCTF_DYNAMIC_FLAG_edd548901769b19d5d695ff2 {} + >> /etc/rsctf-flag-targets 2>/dev/null || true; \
      fi; \
    done; \
    sort -u /etc/rsctf-flag-targets > /etc/rsctf-flag-targets.sorted; \
    mv /etc/rsctf-flag-targets.sorted /etc/rsctf-flag-targets; \
    while IFS= read -r target; do [ -f "$target" ] && chmod a+w "$target"; done < /etc/rsctf-flag-targets
ENTRYPOINT ["/usr/local/bin/rsctf-entrypoint"]
