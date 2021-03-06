/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bugjc.java.libs.tika.example;

import org.apache.tika.Tika;

import java.io.File;

public class SimpleTypeDetector {
    public static void main(String[] args) throws Exception {
        Tika tika = new Tika();

        for (String file : args) {
            String type = tika.detect(new File(file));
            System.out.println(file + ": " + type);
        }
    }
}
