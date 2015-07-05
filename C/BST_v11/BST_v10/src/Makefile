BIN_DIR=bin
CC=gcc
LDFLAGS=
INCLUDE_DIR=include
CFLAGS=-c -I$(INCLUDE_DIR)
SOURCES=bst_create.c bst_insert.c bst_inorder.c bst_preorder.c bst_postorder.c bst_delete.c bst_search.c main.c
OBJECTS=$(SOURCES:.c=.o)
EXECUTABLE=bst

all: $(SOURCES) $(EXECUTABLE)
	
$(EXECUTABLE): $(OBJECTS) 
	$(CC) $(LDFLAGS) $(OBJECTS) -o ../$(BIN_DIR)/$@

.c.o:
	$(CC) $(CFLAGS) $< -o $@
