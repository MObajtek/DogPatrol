package logistyka.save_load;

import logistyka.*;
import logistyka.errand.Errand;
import logistyka.review.Review;

import java.io.*;
import java.util.*;

public class Save {
    
    public static HashMap<Integer, ArrayList<String>> reviewsToHashmap(Owner owner){

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (Review rev: owner.getReviews()) {
            if (map.containsKey(rev.getStars()))
                map.get(rev.getStars()).add(rev.getComment());
            else
                map.put(rev.getStars(),new ArrayList<>(List.of(rev.getComment())));
        }
        return map;
    }
    public static HashMap<Integer, ArrayList<String>> reviewsToHashmap(Walker walker){

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (Review rev: walker.getReviews()) {
            if (map.containsKey(rev.getStars()))
                map.get(rev.getStars()).add(rev.getComment());
            else
                map.put(rev.getStars(),new ArrayList<>(List.of(rev.getComment())));
        }
        return map;
    }
    public static void saveOwnerReviews(HashMap<Integer,ArrayList<String>> map, String reviewHolder){
        File clientDir = new File ("src\\res\\owners\\" + reviewHolder);
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\owners\\" + reviewHolder + "\\reviews.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<Integer, ArrayList<String>> entry :
                    map.entrySet()) {
                bf.write(entry.getKey() + ":"
                        + entry.getValue());
                bf.newLine();
            }
            bf.flush();
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
    public static void saveOwnerInfo(Owner owner) throws IOException {
        File clientDir = new File ("src\\res\\owners\\" + owner.getDescription().getName());
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\owners\\" + owner.getDescription().getName() + "\\info.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            bf.write(owner.getDescription().getName() + ";" +
                    owner.getDescription().getAge() + ";" +
                    owner.getDescription().getHomeRegion() + ";" +
                    owner.getDescription().getBio());

            bf.flush();
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
    public static void saveOwnerInfo(Description description) throws IOException {
        File clientDir = new File ("src\\res\\owners\\" + description.getName());
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\owners\\" + description.getName() + "\\info.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            bf.write(description.getName() + ";" +
                    description.getAge() + ";" +
                    description.getHomeRegion() + ";" +
                    description.getBio());
            bf.flush();
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
    public static void saveOwnerErrands(Owner owner){
        File clientDir = new File ("src\\res\\owners\\" + owner.getDescription().getName());
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\owners\\" +owner.getDescription().getName() + "\\errands.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Errand entry :
                    owner.getListOfErrands()) {
                bf.write(entry.toString());
                bf.newLine();
            }
            bf.flush();
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
    public static void saveOwnerPets(Owner owner){
        for (Pet pet: owner.getListOfPets()) {
            Save.savePetInfo(pet, owner.getDescription().getName());
        }
    }
    public static void savePetInfo(Pet pet, String ownerName){


        File clientDir = new File ("src\\res\\owners\\" + ownerName + "\\pets\\" + pet.getDescription().getName());
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        File file = new File("src\\res\\owners\\" + ownerName + "\\pets\\" + pet.getDescription().getName() + "\\info.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            bf.write(pet.getDescription().getName() + ";" +
                    pet.getDescription().getAge() + ";" +
                    pet.getDescription().getHomeRegion() + ";" +
                    pet.getDescription().getBio() + ";" +
                    pet.getBreed() + ";" +
                    pet.getActivityScale());

            bf.flush();
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
    public static void saveOwner(Owner owner) throws IOException {
        Save.saveOwnerInfo(owner);
        Save.saveOwnerReviews(Save.reviewsToHashmap(owner),owner.getDescription().getName());
        Save.saveOwnerErrands(owner);
        new File ("src\\res\\owners\\" + owner.getDescription().getName() + "\\pets\\").mkdirs();
        Save.saveOwnerPets(owner);
    }
    public static void saveOwner(Description description) throws IOException {
        File file;
        Save.saveOwnerInfo(description);
        file = new File("src\\res\\owners\\" + description.getName() + "\\reviews.txt");
        file = new File("src\\res\\owners\\" + description.getName() + "\\errands.txt");

        new File ("src\\res\\owners\\" + description.getName() + "\\pets\\").mkdirs();

    }

    public static void saveWalkerInfo(Walker walker) throws IOException {
        File clientDir = new File ("src\\res\\walkers\\" + walker.getDescription().getName());
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\walkers\\" + walker.getDescription().getName() + "\\info.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            bf.write(walker.getDescription().getName() + ";" +
                    walker.getDescription().getAge() + ";" +
                    walker.getDescription().getHomeRegion() + ";" +
                    walker.getDescription().getBio());

            bf.flush();
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
    public static void saveWalkerInfo(Description description) throws IOException {
        File clientDir = new File ("src\\res\\walkers\\" + description.getName());
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\walkers\\" + description.getName() + "\\info.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            bf.write(description.getName() + ";" +
                    description.getAge() + ";" +
                    description.getHomeRegion() + ";" +
                    description.getBio());
            bf.flush();
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
    public static void saveWalkerErrands(Walker walker){
        File clientDir = new File ("src\\res\\walkers\\" + walker.getDescription().getName());
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\walkers\\" + walker.getDescription().getName() + "\\errands.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Errand entry :
                    walker.getListOfErrands()) {
                bf.write(entry.toString());
                bf.newLine();
            }
            bf.flush();
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
    public static void saveWalkerReviews(HashMap<Integer,ArrayList<String>> map, String reviewHolder){
        File clientDir = new File ("src\\res\\walkers\\" + reviewHolder);
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\walkers\\" + reviewHolder + "\\reviews.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<Integer, ArrayList<String>> entry :
                    map.entrySet()) {
                bf.write(entry.getKey() + ":"
                        + entry.getValue());
                bf.newLine();
            }
            bf.flush();
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
    public static void saveWalker(Walker walker) throws IOException {
        Save.saveWalkerInfo(walker);
        Save.saveWalkerReviews(Save.reviewsToHashmap(walker),walker.getDescription().getName());
        Save.saveWalkerErrands(walker);
    }
    public static void saveWalker(Description description) throws IOException {
        File file;
        Save.saveWalkerInfo(description);
        file = new File("src\\res\\walkers\\" + description.getName() + "\\reviews.txt");
        file = new File("src\\res\\walkers\\" + description.getName() + "\\errands.txt");


    }

    public static void addOwnerErrand(){};
    public static void addWalkerErrand(){};

}
