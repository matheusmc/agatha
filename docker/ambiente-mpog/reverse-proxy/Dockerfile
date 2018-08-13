FROM nginx
MAINTAINER Cédric Lamalle <cedric.lamalle@basis.com.br>

#ADD https://github.com/kelseyhightower/confd/releases/download/v0.11.0/confd-0.11.0-linux-amd64 /usr/local/bin/confd
#RUN chmod +x /usr/local/bin/confd

COPY env.sh /
RUN chmod 777 /env.sh

COPY proxy.conf /etc/nginx/proxy.conf
COPY default.conf /etc/nginx/conf.d/default.conf

CMD ["sh", "-c", "/env.sh && nginx -g \"daemon off;\""]


