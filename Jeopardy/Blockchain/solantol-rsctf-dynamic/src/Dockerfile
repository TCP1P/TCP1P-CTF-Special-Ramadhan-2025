FROM dimasmaualana/solana:latest@sha256:112d5e7eaea66b51e52da4a5c5b064ad16b17179d252966420b4a529a41a9c00

ENV LAUNCHER_PORT=8080
EXPOSE 8080

RUN grep -q -- '--workers 4' /startup/96-start-launcher \
    && grep -q -- '--threads 8' /startup/96-start-launcher \
    && sed -i 's/--workers 4/--workers 1/; s/--threads 8/--threads 4/' /startup/96-start-launcher

WORKDIR /home/ctf/
COPY ./setup/package.json ./setup/package.json
RUN cd setup && yarn
COPY ./setup/ /home/ctf/setup/
RUN cd setup \
    && anchor keys sync \
    && anchor build --no-idl \
    && RUSTUP_TOOLCHAIN=solana RUSTC_BOOTSTRAP=1 anchor idl build --out target/idl/setup.json
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
        find "$root" -xdev -type f ! -path /usr/local/bin/rsctf-entrypoint -exec grep -lF -e RSCTF_DYNAMIC_FLAG_a4e43355964a3aff9 -e RSCTF_DYNAMIC_FLAG_45edb922 {} + >> /etc/rsctf-flag-targets 2>/dev/null || true; \
      fi; \
    done; \
    sort -u /etc/rsctf-flag-targets > /etc/rsctf-flag-targets.sorted; \
    mv /etc/rsctf-flag-targets.sorted /etc/rsctf-flag-targets; \
    while IFS= read -r target; do [ -f "$target" ] && chmod a+w "$target"; done < /etc/rsctf-flag-targets
ENTRYPOINT ["/usr/local/bin/rsctf-entrypoint"]
CMD ["/entrypoint.sh"]
