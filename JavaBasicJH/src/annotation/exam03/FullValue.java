package annotation.exam03;

public @interface FullValue {
	String name();
	String type() default "b";
}
