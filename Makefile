# CSC3002F OS2 Part 3 Makefile
# Tana Feyt (FYTTAN001)
# 27/04/19

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc
JVM=java

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES= BarrierReusable.class Methane.class Carbon.class Hydrogen.class RunSimulation.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

compile: $(CLASS_FILES)

run:	
	$(JVM) -cp $(BINDIR) java molecule.RunSimulation 12 3

clean:
	rm $(BINDIR)/*.class
docs:
	javadoc -d $(DOCDIR)/ -private $(SRCDIR)/*.java
