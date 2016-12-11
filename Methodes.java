package projet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class Methodes {

	/**
	 * Methode permettant de recuperer le nom des methodes, leurs arguments et
	 * le type de retour de la classe c stockees dans une liste de String
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Une liste De String contenant le nom des methodes et les
	 *         spécifications
	 */
	public static String[] getMethods(Class<?> c) {
		Method[] m = c.getDeclaredMethods();
		int l = m.length;
		String[] str = new String[l];

		for (int i = 0; i < l; i++) {
			str[i] = "";
		}
		for (int i = 0; i < l; i++) {
			str[i] = str[i] + m[i].getName();

			str[i] = str[i] + "( ";

			Class<?>[] t = m[i].getParameterTypes();
			for (int j = 0; j < t.length; j++) {
				str[i] = str[i] + t[j].getSimpleName() + " ";
			}

			str[i] = str[i] + ") : ";

			str[i] = str[i] + m[i].getReturnType().getSimpleName();

		}

		return str;
	}

	/**
	 * Methode permettant de recuperer le nom d'un package a partir d'une classe
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Un String du nom du package contenant la classe etudiee
	 */
	public static String getNomPackage(Class<?> c) {
		return c.getPackage().getName();
	}

	/**
	 * Methode permettant de recuperer le nom des constructeurs et leurs
	 * arguments de la classe c stockees dans une liste de String
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Une liste De String contenant le nom des constructeurs et les
	 *         specifications
	 */
	public static String[] getConstructeurs(Class<?> c) {
		Constructor[] constructors = c.getDeclaredConstructors();
		int l = constructors.length;
		String[] str = new String[l];

		for (int i = 0; i < l; i++) {
			str[i] = "";
		}

		for (int i = 0; i < constructors.length; i++) {
			str[i] = str[i]
					+ constructors[i].getName().substring(
							c.getPackage().getName().length() + 1,
							constructors[i].getName().length());

			str[i] = str[i] + "( ";

			for (int j = 0; j < constructors[i].getParameterTypes().length; j++) {
				str[i] = str[i]
						+ constructors[i].getParameterTypes()[j]
								.getSimpleName() + " ";
			}

			str[i] = str[i] + ")";
		}
		return str;
	}

	/**
	 * Methode permettant de recuperer le nom des variables d'instance ainsi que
	 * leur type de la classe c stockees dans une liste de String
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Une liste De String contenant le nom des variables d'instance et
	 *         leur type
	 */
	public static String[] getVariablesInstance(Class<?> c) {
		Field[] fields = c.getDeclaredFields();
		int l = fields.length;
		String[] str = new String[l];

		for (int i = 0; i < l; i++) {
			str[i] = "";
		}

		for (int i = 0; i < l; i++) {
			str[i] = str[i] + fields[i].getName() + " : "
					+ fields[i].getType().getSimpleName();
		}
		return str;
	}

	/**
	 * Methode permettant d'obtenir le nom de la classe mère
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Un String contenant le nom de la classe mere
	 */
	public static String getClasseMere(Class<?> c) {
		String str = "";
		try {
			str = c.getSuperclass()
					.getName()
					.substring(
							c.getSuperclass().getPackage().getName().length() + 1);
		} catch (Exception e) {
			System.out.println("probleme");
		}
		return str;
	}

	/**
	 * Methode permettant de recuperer le nom des classes implementant une
	 * certaine interface
	 * 
	 * @param c
	 *            La classe c dont on veut obtenir des informations
	 * @return Une liste De String contenant le nom des classes implementant la
	 *         classe étudiée
	 */
	public static String[] getClassesImplementant(Class<?> c) {

		Class<?>[] interfaces = c.getInterfaces();
		int l = interfaces.length;
		String[] str = new String[l];

		for (int i = 0; i < l; i++) {
			str[i] = "";
		}

		for (int i = 0; i < l; i++) {
			str[i] = str[i]
					+ interfaces[i].getName().substring(
							interfaces[i].getPackage().getName().length() + 1);
		}
		return str;
	}

	/**
	 * Methode permettant de récuperer les noms des classes d'un package
	 * 
	 * @param str
	 *            nom du package
	 * @return Une liste De String contenant le nom des classes contenue dans un
	 *         package
	 * @throws IOException
	 *             lance une exception si le package n'éxiste pas
	 */
	public static String[] getClasses(String str) throws IOException {
		ClassPath p = ClassPath.from(ClassLoader.getSystemClassLoader());
		ImmutableSet<ClassInfo> classes = p.getTopLevelClasses(str);

		int l = classes.size();
		String[] str1 = new String[l];
		for (int i = 0; i < l; i++) {
			str1[i] = str + ".";
		}
		int i = 0;
		for (ClassInfo classInfo : classes) {
			Class<?> clazz = classInfo.load();
			str1[i] = str1[i] + clazz.getSimpleName();
			i++;

		}
		return str1;
	}

	public static String getType(Class<?> c) {

		String str = "";

		if (c.isInterface()) {
			str = "Interface";
		} else {
			str = "Classe";
		}

		return str;
	}

	/**
	 * Methode permettant de printer une liste de String
	 * 
	 * @param str
	 *            La liste de String à printer
	 */
	public static void write(String[] str) {
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}

	}

}
