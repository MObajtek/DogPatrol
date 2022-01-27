package logistyka.save_load;

import logistyka.Description;
import logistyka.Owner;
import logistyka.Pet;
import logistyka.Walker;
import logistyka.errand.Errand;
import logistyka.region_address.Address;
import logistyka.region_address.Region;
import logistyka.review.Review;

import java.io.*;
import java.util.ArrayList;

public class Load {

    public static Description loadOwnerDescription(String userName){
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src\\res\\owners\\" + userName + "\\info.txt"));
            String[] description = bf.readLine().split(";");
            String[] address = description[2].split(",");
            Description desc = new Description(
                    description[0],
                    Integer.parseInt(description[1]),
                    new Region(new Address(Double.parseDouble(address[0]),Double.parseDouble(address[1])),Integer.parseInt(address[2])),
                    description[3]);
            return desc;

        }
        catch (IOException e) {
            e.printStackTrace();
            return new Description();
        }
        finally {
            try {
                // always close the writer
                bf.close();
            }
            catch (Exception ignored) {
            }
        }

    }
    public static ArrayList<Review> loadOwnerReviews(String userName){
        ArrayList<Review> reviews = new ArrayList<>();
        Integer stars = 0;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src\\res\\owners\\" + userName + "\\reviews.txt"));
            String line;
            while ((line = bf.readLine()) != null){
                String[] parts = line.split(":");
                stars = Integer.parseInt(parts[0]);
                String[] comments = parts[1].replaceAll("\\[*\\]*","").split(",");
                for (String comment: comments) {
                    reviews.add(new Review(stars,comment));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                // always close the writer
                bf.close();
            }
            catch (Exception ignored) {
            }
        }
        return reviews;
    }
    public static ArrayList<Pet> loadPets(String userName){
        ArrayList<Pet> pets = new ArrayList<>();
        File petsDir = new File ("src\\res\\owners\\" + userName + "\\pets");
        File[] files = petsDir.listFiles();
        for (final File fileEntry : files) {
            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader("src\\res\\owners\\" + userName + "\\pets\\" + fileEntry.getName() + "\\info.txt"));
                String[] info = bf.readLine().split(";");
                String[] address = info[2].split(",");
                Description desc = new Description(
                        info[0],
                        Integer.parseInt(info[1]),
                        new Region(new Address(Double.parseDouble(address[0]),Double.parseDouble(address[1])),Integer.parseInt(address[2])),
                        info[3]);
                pets.add(new Pet(desc,info[4],Integer.parseInt(info[5])));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    // always close the writer
                    bf.close();
                }
                catch (Exception ignored) {
                }
            }

        }

        return pets;
    }
    public static ArrayList<Errand> loadOwnerErrands(String userName){
        ArrayList<Errand> errands = new ArrayList<>();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src\\res\\owners\\" + userName + "\\errands.txt"));
            String line;
            while ((line = bf.readLine()) != null){
                String[] parts = line.split(":");
                String[] address = parts[0].split(",");
                errands.add(new Errand(
                        new Address(Double.parseDouble(address[0]),Double.parseDouble(address[1])),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),
                        Boolean.parseBoolean(parts[3]),
                        parts[4]));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                // always close the writer
                bf.close();
            }
            catch (Exception ignored) {
            }
        }
        return errands;
    }
    public static Owner loadOwner(String userName){
        return new Owner(Load.loadOwnerDescription(userName),
                Load.loadOwnerReviews(userName),
                Load.loadOwnerErrands(userName),
                Load.loadPets(userName), 6);
    }

    public static Description loadWalkerDescription(String userName){
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src\\res\\walkers\\" + userName + "\\info.txt"));
            String[] description = bf.readLine().split(";");
            String[] address = description[2].split(",");
            Description desc = new Description(
                    description[0],
                    Integer.parseInt(description[1]),
                    new Region(new Address(Double.parseDouble(address[0]),Double.parseDouble(address[1])),Integer.parseInt(address[2])),
                    description[3]);
            return desc;

        }
        catch (IOException e) {
            e.printStackTrace();
            return new Description();
        }
        finally {
            try {
                // always close the writer
                bf.close();
            }
            catch (Exception ignored) {
            }
        }

    }
    public static ArrayList<Review> loadWalkerReviews(String userName){
        ArrayList<Review> reviews = new ArrayList<>();
        Integer stars = 0;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src\\res\\walkers\\" + userName + "\\reviews.txt"));
            String line;
            while ((line = bf.readLine()) != null){
                String[] parts = line.split(":");
                stars = Integer.parseInt(parts[0]);
                String[] comments = parts[1].replaceAll("\\[*\\]*","").split(",");
                for (String comment: comments) {
                    reviews.add(new Review(stars,comment));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                // always close the writer
                bf.close();
            }
            catch (Exception ignored) {
            }
        }
        return reviews;
    }
    public static ArrayList<Errand> loadWalkerErrands(String userName){
        ArrayList<Errand> errands = new ArrayList<>();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src\\res\\walkers\\" + userName + "\\errands.txt"));
            String line;
            while ((line = bf.readLine()) != null){
                String[] parts = line.split(":");
                String[] address = parts[0].split(",");
                errands.add(new Errand(
                        new Address(Double.parseDouble(address[0]),Double.parseDouble(address[1])),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),
                        Boolean.parseBoolean(parts[3]),
                        parts[4]));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                // always close the writer
                bf.close();
            }
            catch (Exception ignored) {
            }
        }
        return errands;
    }
    public static Walker loadWalker(String userName){
        return new Walker(Load.loadWalkerDescription(userName),
                Load.loadWalkerReviews(userName),
                Load.loadWalkerErrands(userName),
                6);
    }





}
