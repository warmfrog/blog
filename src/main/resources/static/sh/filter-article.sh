#!/bin/bash
# author: warmfrog
# date: 2019/02/11
# for: 处理articles目录下的文件,结果放在results文件夹

# 创建目录results
dir=results
if [ ! -e $dir ]
then
    mkdir $dir
    echo "$dir didn't exist! create $dir"
# 如果存在,则删除,然后创建
else
    rm -rf $dir       
    echo "delete directory $dir"
    mkdir $dir
    echo "create directory $dir"
fi

#对articles目录下的每个文件进行操作
articles=`ls articles`
count=0
for file in $articles   
do
    length=${#file}
    result=${file:11:${length}}  #获取去除日期前缀后的文件名
    ((count++))

    #如果result不存在,则创建
    if [ ! -e results/$result ]  
    then
        cp articles/$file results/$file
        mv results/$file results/$result
        echo "create file results/$result"
    fi
done
echo "articles目录下有$count个文件"

# 删除文件前5行的标记,如果已经删除,要注释该代码段
articles=`ls results`
for file in $articles
do
   article="results/$file" 
   cat $article | sed '1,6d' >> temp
   echo "" > $article
   cat temp >> $article
   echo "modify $article"
   rm temp
done

 # 处理markdown中的图片连接

articles=`ls results`
for file in $articles
do
    article="results/$file"
    sed "{
        s/\(\.\.\/img\/article\)/\/img/
        s/\(\/img\/article\)/\/img/
    }" $article >> temp
    echo "" > $article
    cat temp >> $article
    rm temp
    echo "successful work with $article"
done
