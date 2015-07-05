#! /usr/bin/env python

import os, sys, commands

if len (sys.argv) != 2:
	print "Provide dirname in quotes"
	exit ()

DIR_NAME = sys.argv[1]
TMP_FILE = ".tmp_file.txt"

if not os.path.exists (DIR_NAME):
	print "Path to directory broken"
	exit ()
changeDir = os.chdir (DIR_NAME)
createTEMP = commands.getoutput ("ls > %s 2>/dev/null; echo $?"%(TMP_FILE))

if createTEMP != "0":
	print "Cannot write in directory"
	exit ()

filePointer = open (TMP_FILE)
allFilesList = filePointer.readlines ()
filePointer.close ()
os.system ("rm %s"%TMP_FILE)
allFilesListDup = allFilesList

for eachFile in allFilesList:
	eachFile = eachFile.strip ()
	for eachDupFile in allFilesListDup:
		cpEachDupFile = eachDupFile
		eachDupFile = eachDupFile.strip ()
		if eachDupFile == eachFile:
			continue
		seeDiff = commands.getoutput ("diff \"%s\" \"%s\""%(eachFile, eachDupFile))
		if seeDiff == "":
			print "Removing file %s"%(eachDupFile)
			removeFile = commands.getoutput ("rm \"%s\" 2>/dev/null; echo $?"%eachDupFile)
			if removeFile != "0":
				print "Could not remove duplicate file \"%s\"."
			allFilesListDup.remove (cpEachDupFile)
