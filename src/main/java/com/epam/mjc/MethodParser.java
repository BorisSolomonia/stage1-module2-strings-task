package com.epam.mjc;
import java.util.ArrayList;
import java.util.List;


public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] firstSplit = signatureString.split("[(]");
        StringBuilder stringBuilder = new StringBuilder(firstSplit[1]);
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());

        firstSplit[1] = String.valueOf(stringBuilder);
        String[] secondSplit = firstSplit[0].split(" ");
        String[] thirdSplit = firstSplit[1].split(", ");
        List<MethodSignature.Argument> args = new ArrayList<>();
        for (int i = 0; i < thirdSplit.length; i++) {
            String type = "";
            String ar = "";
            if(i%2 == 0){
                type = thirdSplit[i];
            }else {
                ar = thirdSplit[i];
            }
            args.add(new MethodSignature.Argument(type, ar));
        }

        MethodSignature methodSignature = new MethodSignature(secondSplit[secondSplit.length-1],args);
        methodSignature.setReturnType(secondSplit[secondSplit.length-2]);
        methodSignature.setAccessModifier(secondSplit[0]);
        //throw new UnsupportedOperationException("You should implement this method.");
        //System.out.println(methodSignature.getMethodName() + " " + methodSignature.getAccessModifier() + " " + methodSignature.getReturnType());
        return methodSignature;
    }
}
