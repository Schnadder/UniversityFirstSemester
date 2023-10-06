# CMakeList.txt : CMake project for Oving3, include source and define
# project specific logic here.
#
cmake_minimum_required (VERSION 3.8)

# Enable Hot Reload for MSVC compilers if supported.
if (POLICY CMP0141)
  cmake_policy(SET CMP0141 NEW)
  set(CMAKE_MSVC_DEBUG_INFORMATION_FORMAT "$<IF:$<AND:$<C_COMPILER_ID:MSVC>,$<CXX_COMPILER_ID:MSVC>>,$<$<CONFIG:Debug,RelWithDebInfo>:EditAndContinue>,$<$<CONFIG:Debug,RelWithDebInfo>:ProgramDatabase>>")
endif()

project ("Oving3")

# Add source to this project's executable.
add_executable (Oppg1og2 "CircleClient.cpp" "circle.hpp")
add_executable (Oppg3 "commodityClient.cpp" "commodity.hpp")
add_executable (Oppg4 "Oppg4.cpp")

if (CMAKE_VERSION VERSION_GREATER 3.12)
  set_property(TARGET Oppg1og2 PROPERTY CXX_STANDARD 20)
  set_property(TARGET Oppg3 PROPERTY CXX_STANDARD 20)
  set_property(TARGET Oppg4 PROPERTY CXX_STANDARD 20)
endif()

if (MSVC)
    # Use MSVC-specific flags
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} /W4")
else ()
    # Use GCC/Clang flags for non-Windows platforms
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wall -Wextra")
endif ()
