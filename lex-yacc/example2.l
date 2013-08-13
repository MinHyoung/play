%{
#include <stdio.h>
%}

%%
[0123456789]+           printf("number\n");
[a-zA-Z][a-zA-Z0-9]*    printf("word\n");
%%
