package ar.com.miura.jvm.string;

public class SimplifyPath {
    public String simplifyPath(String path) {

        String[] splitted = path.split("/");

        java.util.Stack<String> stack = new java.util.Stack<String>();
        for(String directory:splitted) {

            if (directory.equals(".") || directory.isEmpty()) {
                continue;

            } else if (directory.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(directory);

            }

        }

        StringBuilder sBuilder = new StringBuilder();

        java.util.List<String> directories = new java.util.ArrayList<String>();
        while(!stack.isEmpty()) {
            String directory = stack.pop();
            directories.add(directory);
        }
        java.util.Collections.reverse(directories);

        for(String directory:directories) {
            sBuilder.append("/");
            sBuilder.append(directory);
        }

        if (sBuilder.length()==0) {
            return "/";

        } else {
            return sBuilder.toString();

        }

    }
}
