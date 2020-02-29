package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;


public class Main
        {
            public static Map<String, Integer> countWords(ArrayList<String> list)
            {
                HashMap<String, Integer> result = new HashMap<String, Integer>();

                String word_1, word_2;
                int count=0;
                for (int i=0;i<list.size();i++)
                {
                    word_1 = list.get(i);
                    count = 1;
                    if(word_1.isEmpty())
                    {
                        count--;
                        break;
                    }
                    for (int j=i+1;j<list.size();j++)
                    {
                        word_2 = list.get(j);
                        if (word_1.equals(word_2))
                        {
                            count++;
                            list.remove(j);
                            j--;
                        }
                    }
                    result.put(word_1,count);
                }
                return result;
            }

            public static boolean Number(String str)
            {
                for(int i=0;i<str.length();i++)
                {
                    if(Character.isDigit(str.charAt(i)))
                    {
                        System.out.println(str);
                        return true;
                    }
                }
                return false;
            }

            public static boolean Regex(String str)
            {
                for(int i=0;i<str.length();i++)
                {
                    if(Character.isLetter(str.charAt(i)))
                    {
                        System.out.println(str);
                        return true;
                    }
                }
                return false;
            }




            public static void main(String[] args) throws NoSuchElementException, FileNotFoundException {

                File file = new File("C:\\XYЙ", "book.txt");


// ПОДСЧЁТ КОЛИЧЕСТВА говна
                int countWord = 0;
                int countNumb = 0;
                int countLines = 0;
                int countWord1 = 0;
                int letters = 0;

                Scanner sc = new Scanner(file);
                Scanner sc1 = new Scanner(file);
                Scanner sc2 = new Scanner(file);
                Scanner sc3 = new Scanner(file);

                while (sc3.hasNext())
                {
                    String str = sc3.next();

                    if (Regex(str) == true)
                    {
                        letters++;
                    }


                }

                while (sc.hasNextLine())
                {
                    countLines++;
                    String[] array1 = sc.nextLine().split( "\\s+"+"\\b");
                    countWord = countWord + array1.length;

                }
                while(sc1.hasNext())
                {
                    String str = sc1.next();
                    if(Number(str)==true)
                    {
                        countNumb++;
                    }

                }

                ArrayList<String> word = new ArrayList<String>();
                for (int i = 0; i < countWord; i++)
                {

                    word.add(sc2.next().replaceAll("\\p{Punct}", ""));

                    countWord1 = countWord1 + 1;

                }

                Map<String, Integer> map = countWords(word);

                for (Map.Entry<String, Integer> pair : map.entrySet())
                {
                    System.out.println(pair.getKey() + " " + pair.getValue());
                }

                sc.close();
                sc1.close();
                sc2.close();
                sc3.close();


                System.out.println("Количество слов: " + countWord1);
                System.out.println("Количество строк: " + countLines);
                System.out.println("количество чисел: " + countNumb);
                System.out.println("количество букв: " + letters);



            }

        }

