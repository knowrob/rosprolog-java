cmake_minimum_required(VERSION 2.8.3)
project(rosprolog_java)

find_package(catkin REQUIRED COMPONENTS rosprolog rosjava_build_tools rosjava_bootstrap json_prolog_msgs rosjava_messages rosprolog rosjava_build_tools rospy roscpp
)

catkin_rosjava_setup(installDist publishMavenJavaPublicationToMavenRepository writeClasspath)
catkin_package(
  CATKIN_DEPENDS json_prolog_msgs
)
include_directories(include ${catkin_INCLUDE_DIRS})

install(
  DIRECTORY ${CATKIN_DEVEL_PREFIX}/${CATKIN_GLOBAL_MAVEN_DESTINATION}/org/knowrob/${PROJECT_NAME}/
  DESTINATION ${CATKIN_GLOBAL_MAVEN_DESTINATION}/org/knowrob/${PROJECT_NAME}
)
