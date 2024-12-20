Tabelas e suas cardinalidades:

Apartamento
- Apartamento 1:N Moradores.

Moradores
- Moradores 1:N AnimaisEstimacao.
- Moradores 1:N Veiculos.
- Moradores 1:N Visitantes.
- Moradores 1:N Reservas.

AnimaisEstimacao
- Moradores 1:N AnimaisEstimacao.

Veiculos
- Moradores 1:N Veiculos.

Visitantes
- Moradores 1:N Visitantes.

Reservas
- Moradores 1:N Reservas.
- AreasComuns 1:N Reservas.

AreasComuns
- AreasComuns 1:N Reservas.

Este modelo é enxuto, foca nas cardinalidades essenciais e está preparado para ser expandido conforme novas necessidades surgirem.
