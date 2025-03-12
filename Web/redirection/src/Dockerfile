FROM python:alpine

RUN pip3 install requests flask gunicorn

WORKDIR /app
COPY ./src/app.py ./app.py

USER 1001

ENV FLAG "RAMADAN{open_redirection_on_youtube_is_really_handy}"

CMD [ "sh", "-c", "python3 -m gunicorn --bind 0.0.0.0:8080 -w 8 app:app" ]
