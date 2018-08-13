#!/bin/bash

sed -i 's|${ENDERECO_SGR}|'"$ENDERECO_SGR"'|' /etc/nginx/conf.d/default.conf


