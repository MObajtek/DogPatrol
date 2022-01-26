package logistyka.save_load;

import logistyka.*;
import logistyka.errand.Errand;
import logistyka.review.Review;

import java.io.*;
import java.util.*;

public class Save {

    public static HashMap<String, String> descriptionToHashmap(Description description){
        HashMap<String, String> map = new HashMap<>();
        map.put("name",description.getName());
        map.put("age",String.valueOf(description.getAge()));
        map.put("address",description.getHomeRegion().getCurrentAddress().toString());
        map.put("radius",String.valueOf(description.getHomeRegion().getRadius()));
        map.put("bio",description.getBio());
        return map;
    }

    public static void saveOwnerInfo(Owner owner) throws IOException {
        HashMap<String,String> map = Save.descriptionToHashmap(owner.getOwnerDescription());
        File clientDir = new File ("src\\res\\" + map.get("name"));
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\" + map.get("name") + "\\info");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry :
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

    public static void saveReviews(HashMap<Integer,ArrayList<String>> map, String reviewHolder){
        File clientDir = new File ("src\\res\\" + reviewHolder);
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\" + reviewHolder + "\\reviews");
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

    public static void saveOwnerErrands(Owner owner){
        File clientDir = new File ("src\\res\\" + owner.getOwnerDescription().getName());
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\" +owner.getOwnerDescription().getName() + "\\errands");
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
            Save.savePetInfo(pet, owner.getOwnerDescription().getName());
        }
    }

    public static void savePetInfo(Pet pet, String ownerName){
        HashMap <String, String> petInfo = Save.descriptionToHashmap(pet.getDescription());
        petInfo.put("breed",pet.getBreed());
        petInfo.put("activity",String.valueOf(pet.getActivityScale()));

        File clientDir = new File ("src\\res\\" + ownerName + "\\pets\\" + petInfo.get("name"));
        try{
            if(clientDir.mkdirs()) {
                System.out.println("Directory Created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        File file = new File("src\\res\\" + ownerName + "\\pets\\" + petInfo.get("name") + "\\info");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry :
                    petInfo.entrySet()) {
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


    public static void saveOwner(Owner owner) throws IOException {
        Save.saveOwnerInfo(owner);
        Save.saveReviews(Save.reviewsToHashmap(owner),owner.getOwnerDescription().getName());
        Save.saveOwnerErrands(owner);
        Save.saveOwnerPets(owner);
    }




}
