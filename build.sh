DIR=`pwd`

RED='\033[0;31m'
NC='\033[0m' # No Color

build_project() {
  echo building $1 with version $2  
  if [[ -d $DIR/$1 ]]; then
    echo -e "${RED} The directory $DIR/$1 does NOT Exist ${NC}"
    echo "Please run gitsub.sh first"
  fi
  cd $DIR/$1
  status=$?
  gradle publishToMavenLocal -Ptag=$2
  status=$?
  if [[ "0" == "$status" ]]; then
   echo -e "${RED} Build.sh Failed with exit code $status ${NC}"
   exit 0;
  fi
}

run_tests() {
  echo running tests in $1 
  cd $DIR/$1
  status=$?
  gradle build
  status=$?
  if [[ "0" == "$status" ]]; then
   echo -e "${RED} Build.sh Failed with exit code $status ${NC}"
   exit 0;
  fi
}

build_project i_tests4j.adligo.org v0_1+_SNAPSHOT
build_project i_pipe.adligo.org v0_4+_SNAPSHOT
build_project pipe.adligo.org v0_1+_SNAPSHOT
