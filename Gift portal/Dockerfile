FROM node:latest AS build 

WORKDIR /app
COPY . /app

RUN npm install npm@latest
RUN npm install
RUN npm build

FROM  ubuntu
RUN apt-get update
RUN apt-get install nginx- y
COPY --from=build /app/dist/va