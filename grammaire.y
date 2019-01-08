programme	: listOptDef blocInst
;

listOptDef	: listDef
		| 
;

listDef	:Def
	| Def listDef
	;
	
	Def	:defClasse
		| DefObj
;

defClasse : CLASS nomClasse BRACO listOptParam BRACC heritOpt IS CBRACO listOptChamps defConst listOptMeth CBRACC
;

listOptParam	: listParam
		|
		;

listParam	:param
		|param COMA listParam
		;

param	:nom COL nomClasse
	| VAR nom COL nomClasse
	;
	
heritOpt	:EXT nomClasse

defConst	:DEF nomClasse BRACO listOptParam BRACC superClasseOpt IS CBRACO corps CBRACC
;

corps	: listAff
	|
	;
	
listAff	: aff
	| aff listAff
	;

superClasseOpt	: nomClasse BRACO listOptParam2 BRACC
		;

listOptParam2	:listParam2
		|
		;

listParam2	: nomVar
		| nomVar COMA listParam2
		;

listOptChamps	: listChamps
|
;
listChamps	: champ
		| champ listChamps
		;

champ	: VAR nom COL comClasse SCOL

listOptMeth	: listMeth
	|
	;

listMeth	: methode
	| methode listMeth
	;
		 
methode: overrideOpt DEF typeMethode
;

overrideOpt	:OVR
		| 
;

typeMethode	: nom BRACO listParamOpt BRACC COL nomClasse AFFECT E
		| nom BRACO listParamOpt BRACC COL nomClasseOpt IS bloc
		;

nomClasseOpt 	: COL nomClasse
		|
		;

E	: ident
	| const
	| BRACO E BRACC
	| BRACO nomClasse E BRACC
	| selec
	| instanciation	
	| envMess
	| exprOperateur
	;

ident	: nom
| this
| super
| result
;

selec	:E.nom
;

instanciation	: NEW nomClasse BRACO listOptParam2 BRACC
;

blocInst 	: inst
| inst blocInst
;

inst	: E SCOL
| bloc
| RETURN SCOL
| aff
| IF E THEN inst ELSE inst
;

bloc 	: CBRACO listOptInst CBRACC
|CBRACO listDecl IS listInst CBRACC
;

listOptInst	: listInst
|
;

listInst	: inst listInst
| inst
;

listDecl	: decl listDecl
| decl
;

decl	: nom COL nomClasse expOpt SCOL
;

expOpt	: AFFECT E
|
;

aff 	: cible AFFECT E SCOL
;

DefObj	: OBJ nomClasse IS CBRACO listOptChamps defConstObj listOptMeth CBRACC
;

defConstObj	: DEF nomClasse IS CBRACO corps CBRACC










