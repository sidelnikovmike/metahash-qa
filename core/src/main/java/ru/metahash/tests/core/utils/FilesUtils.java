package ru.metahash.tests.core.utils;


import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Utils for work with files
 */
public class FilesUtils {

    /**
     * returns list of files for resource path folder
     *
     * @param resourcePath folder from resources
     * @return list of files names
     */
    public static List<String> getFilesForResourcePath(String resourcePath) {
        try {
            InputStream stream = FilesUtils.class.getClassLoader()
                    .getResourceAsStream(resourcePath);
            if (stream == null) {
                throw new IllegalStateException("No file found for path '" + resourcePath + "'. Check resources.");
            }
            return IOUtils.readLines(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * returns list of file's lines
     *
     * @param resourceFilePath folder from resources
     * @return list of files names
     */
    public static List<String> getLinesFileResource(String resourceFilePath) {
        try {
            String path = getFormattedFilePath(resourceFilePath);
            InputStream stream = FilesUtils.class.getResourceAsStream(path);
            if (stream == null) {
                throw new IllegalStateException("No file found for path '" + path + "'. Check resources.");
            }
            return IOUtils.readLines(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * returnes sources of file from resources
     *
     * @param resourceFilePath path to file in resources
     * @return file source
     */
    public static String getResourcesFileSource(String resourceFilePath) {
        try {
            String path = getFormattedFilePath(resourceFilePath);
            InputStream stream = FilesUtils.class.getResourceAsStream(path);
            if (stream == null) {
                throw new IllegalStateException("No file found for path '" + path + "'. Check resources.");
            }

            return IOUtils.toString(stream, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * returnes sources of file by absolute path
     *
     * @param resourceFilePath absolute path to file
     * @return file source
     */
    public static String getFileSource(String resourceFilePath) {
        try {
            return IOUtils.toString(new FileInputStream(getFormattedFilePath(resourceFilePath)), StandardCharsets.UTF_8);
        } catch (FileNotFoundException fnfe) {
            throw new IllegalStateException(fnfe.getMessage());
        } catch (IOException ioe) {
            throw new RuntimeException("Error while reading file with path '" + resourceFilePath + "'", ioe);
        }
    }

    private static String getFormattedFilePath(String resourceFilePath) {
        if (!resourceFilePath.startsWith("/")) {
            resourceFilePath = "/" + resourceFilePath;
        }
        return resourceFilePath;
    }

    private static boolean isFile(String resourceEntityName) {
        return resourceEntityName.contains(".");
    }

    /**
     * returns list of files for resource folder path and subfolders
     *
     * @param resourcePath folder from resources
     * @return list of files names
     */
    public static List<String> getResourceFilesNames(String resourcePath) {
        List<String> files = new ArrayList<>();
        List<String> filesToAdd = getFilesForResourcePath(resourcePath);
        if (filesToAdd != null) {
            for (String resourceEntityName : filesToAdd) {
                if (isFile(resourceEntityName)) {
                    files.add(resourcePath + "/" + resourceEntityName);
                } else {
                    List<String> subDirFilesNames = getResourceFilesNames(resourcePath + "/" + resourceEntityName);
                    if (subDirFilesNames != null && !subDirFilesNames.isEmpty()) {
                        files.addAll(subDirFilesNames);
                    }
                }
            }
        }
        return files;
    }


}
