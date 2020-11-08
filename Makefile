SRC = ./src/SharingNotes/

install:
	sudo apt-get install sbt

compile:
	cd $(SRC) && sbt compile

run:
	cd $(SRC) && sbt run

test:
	cd $(SRC) && sbt test

clean:
	cd $(SRC) && sbt clean
