#!/bin/bash

# 检查参数数量
if [ "$#" -lt 2 ]; then
  echo "error: arguments should not be greater than 1"
  exit 1
fi

# 读取参数
param1="$1"
param2="$2"
param3="$3"

# 根据参数执行不同的操作
if [ "$param1" = "start" ]; then
  cd $param2
  otree prodserver $param3
  # 在这里添加选项1的操作
elif [ "$param1" = "stop" ]; then
  echo "stop otree server on port $param3"
  process=$(lsof -i :$param3 | awk 'NR==2{print $2}')
  if [[ ! -z $process ]]; then
    echo "Port $param3 is in use by process $process. Killing the process..."
    kill -9 $process
    echo "Process $process killed."
  # 在这里添加选项2的操作
elif [ "$param1" = "delete" ]; then
  echo "delete project $param2"
  pwd
  rm -rf $param2
  # 在这里添加选项2的操作
elif [ "$param1" = "unzip" ]; then
  echo "unzip $param2.otreezip"
  otree unzip $param2.otreezip
  rm -f $param2.otreezip
  # 在这里添加选项2的操作
fi

fi
