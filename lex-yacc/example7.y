%{
#include <stdio.h>
#include <string.h>

int yydebug = 1;

void yyerror(const char *str)
{
    fprintf(stderr,"error: %s\n",str);
}

int yywrap()
{
    return 1;
}

main()
{
    yyparse();
}

char *heater="default";

%}

%token TOKHEATER TOKHEAT TOKTARGET TOKTEMPERATURE

%union {
    int number;
    char *string;
}

%token <number> STATE
%token <number> NUMBER
%token <string> WORD

%%

commands:
    | commands command
    ;

command:
    heat_switch | target_set | heater_select

heat_switch:
    TOKHEAT STATE {
        if($2) {
            printf("\theater '%s' turned on\n", heater);
        } else {
            printf("\theater '%s' turned off\n", heater);
        }
    }
    ;

target_set:
    TOKTARGET TOKTEMPERATURE NUMBER {
        printf("\theater '%s' temperature set to %d\n",heater, $3);
    }
    ;

heater_select:
    TOKHEATER WORD {
        printf("\tselected heater '%s'\n",$2);
        heater=$2;
    }
    ;