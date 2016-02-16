 
## Interface: 
Una interfaz se crea con el objetivo de definir que cosas puede hacer una clase, pero no como debe hacerlo. Una interfaz puede ser implementada por cualquier clase. Esta posibilita tener clases diferentes con caracteristicas comunes.

#### Ejemplo:

Declaración de una clase interface
``` java
 interface mamifero{
    public void comer();
    public void moverse();
    public void dormir();
 }
```
Implementación de una clase interface
``` java
public class oso implements mamifero{
    @Override
    public void comer(){
        System.out.println("El oso esta comiendo");
    }
    
    public void moverse(){
        System.out.println("El oso se esta moviendo");
    }
    
    public void dormir(){
        System.out.println("El oso esta durmiendo");
    }
}
```
 
## Abstract class:
Una clase abstracta se crea con el fin de declarar uno o muchos métodos abstractos que buscan ser extendidos por una subclase, no necesariamente todos los metodos deben ser abstractos tambien pueden haber algunos metodos implementados. Una clase abstracta no puede ser instanciada.

#### Ejemplo:

Declaración de una clase abstracta
``` java
 abstract class InstrumentoDeCuerda{
    protected String nombre;
    protected int cuerdas;
    abstract public void tocar();
 }
```

Implementación de una clase abstracta
``` java
public class guitarra extends InstrumentoDeCuerda{
    @Override
    public void guitarra(){
        super();
    }
    public void tocar(){
        System.out.println("La guitarra esta sonando");
    }
}
```

## Static field:
Cuando se requieren tener variables comunes en muchos objetos se hace uso de *static field*. Este campo esta asociado a la clase y no al objeto.

#### Ejemplo:

``` java
public class Calculadora{
    private static double PI = 3.1416;
 }
```