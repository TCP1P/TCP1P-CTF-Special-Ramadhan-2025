FROM python:3.10-slim

WORKDIR /app

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY . .

RUN flag_name=$(openssl rand -hex 8) && mv flag.txt /$flag_name.txt && chmod 444 /$flag_name.txt

EXPOSE 5000

# user ctf
RUN useradd -m ctf

USER ctf

CMD ["python", "app.py"]