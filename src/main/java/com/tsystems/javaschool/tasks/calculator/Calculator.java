package com.tsystems.javaschool.tasks.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Calculator {

    public String evaluate(String statement) {
        if ((statement == null) || (statement.equals(""))) {
            return null;
        }
        for (int i = 0; i < statement.length(); i++) {
            char c = statement.charAt(i);
            if ((!Character.isDigit(c)) && (c != '-') && (c != '+') && (c != '.') && (c != ')') && (c != '(') && (c != '/') && (c != '*')) {
                return null;
            }
        }
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            String result = String.valueOf(engine.eval(statement));
            if (result.equals("Infinity")) {
                return null;
            }
            return String.valueOf(engine.eval(statement));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}