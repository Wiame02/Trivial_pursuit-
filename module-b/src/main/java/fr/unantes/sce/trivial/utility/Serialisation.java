package fr.unantes.sce.trivial.utility;

import java.io.*;

import fr.unantes.sce.trivial.model.ManageUsers;
import fr.unantes.sce.trivial.model.Stack;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Serialisation
{
	
	public static void saveStack(String nomFichier, Stack stack)
	{
		
		Gson gson = new GsonBuilder().registerTypeAdapter(Stack.class, new MyTypeAdapter<Stack>()).create();
		PrintWriter pw = null;
		
		try
		{
			pw = new PrintWriter(nomFichier); 
			pw.write(gson.toJson(stack));
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
			if(pw!=null)
			{
				pw.close();
			}
		}
			 
	}
	
	public static Stack retrieveStack(InputStream nomFichier){
		
		Gson gson = new Gson();
		Stack stack = null;
		BufferedReader br = null;
		
		try {
			 br = new BufferedReader(new InputStreamReader(nomFichier));
			stack = gson.fromJson(br, Stack.class);

		} finally{
			
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return stack;
	}
	
	public static void saveManageUsers(ManageUsers manageUsers, File file)
	{
		FileOutputStream out = null;
		XStream xStream = null;
		
		try {
			xStream = new  XStream(new DomDriver());
			out = new FileOutputStream(file);
			xStream.toXML(manageUsers, out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	
	public static ManageUsers retrieveManageUsers(InputStream is)
	{
		XStream xStream = null;
		FileInputStream in = null;
		Object tmp = null;
		ManageUsers manageUsers = null;
		
		try {
			xStream = new XStream(new DomDriver());
			xStream.allowTypesByWildcard(new String[]{"fr.unantes.sce.trivial.model.**"});
			//in = new FileInputStream(file);
			tmp = xStream.fromXML(is);
			if(tmp instanceof ManageUsers){
				manageUsers = (ManageUsers) tmp;
			}
		} finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return manageUsers;
	}
	
	
	
}

