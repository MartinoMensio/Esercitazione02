# Esercitazione 2

## Installazione

Prerequisito: avere docker installato.

```bash
# creare un volume docker
docker volume create
# per fare il build assicurarsi di essere nella cartella con il Dockerfile
# ai/lab2 è il nome dell'immagine
docker build -t ai/lab2 .
# controllare che il container esista listando le images
docker images
# esegue l'immagine dando nome postgis all'istanza in esecuzione
# -d modalità detached
docker run --name postgis -v Laboratorio2:/datadb -p 5432:5432 -d ai/lab2
# controllare che sia in esecuzione e con la porta 5432
docker ps
# eseguire bash in modalità interattiva dentro il container
docker exec -it postgis bash
# aprire il db trasporti con utente postgres
psql -U postgres -d trasporti
# mostra le tabelle del db
\d
# comando per uscire
\q
```
