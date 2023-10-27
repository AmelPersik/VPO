package triangle;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    // 1
    // ok
    @Test
    public void checkTriangle_Correct_tst(){
        var tr = new Triangle(15.3, 14.2, 8.77);
        Assert.assertTrue(tr.checkTriangle());
    }

    // 2
    // ok
    @Test
    public void checkTriangle_Zero_A_tst(){
        var tr = new Triangle(0, 5, 6);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 3
    // ok
    @Test
    public void checkTriangle_Zero_B_tst(){
        var tr = new Triangle(1, 0, 6);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 4
    // ok
    @Test
    public void checkTriangle_Zero_C_tst(){
        var tr = new Triangle(4, 5, 0);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 5
    // ok
    @Test
    public void checkTriangle_Negative_A_tst(){
        var tr = new Triangle(-1, 5, 6);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 6
    // ok
    @Test
    public void checkTriangle_Negative_B_tst(){
        var tr = new Triangle(7, -5, 6);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 7
    // ok
    @Test
    public void checkTriangle_Negative_C_tst(){
        var tr = new Triangle(6, 5, -2.1);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 8
    // тест составлен не корректно (нет оговорки о свойстве сторон треугольника)
    @Test
    public void checkTriangle_Three_More_C_tst(){
        var tr = new Triangle(17,10,3);
        Assert.assertTrue(tr.checkTriangle());
    }

    // 9
    // аналогично
    @Test
    public void checkTriangle_Three_More_B_tst(){
        var tr = new Triangle(16.2, 5, 2.1);
        Assert.assertTrue(tr.checkTriangle());
    }

    // 10
    // значения подошли, но тест аналогично некорректен
    @Test
    public void checkTriangle_Three_More_A_tst(){
        var tr = new Triangle(16, 15, 2.1);
        Assert.assertTrue(tr.checkTriangle());
    }

    // 11
    // ok
    @Test
    public void checkTriangle_Three_Less_C_tst(){
        var tr = new Triangle(6, 5, 22.1);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 12
    // ok
    @Test
    public void checkTriangle_Three_Less_B_tst(){
        var tr = new Triangle(6, 15, 2.1);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 13
    // ok
    @Test
    public void checkTriangle_Three_Less_A_tst(){
        var tr = new Triangle(16.2, 5, 2.1);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 14
    // ok
    @Test
    public void checkTriangle_Three_Equal_C_tst(){
        var tr = new Triangle(1.2, 5.3, 6.5);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 15
    // ok
    @Test
    public void checkTriangle_Three_Equal_B_tst(){
        var tr = new Triangle(11.5, 51, 39.5);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 16
    // ok
    @Test
    public void checkTriangle_Three_Equal_A_tst(){
        var tr = new Triangle(16.2, 5.2, 11);
        Assert.assertFalse(tr.checkTriangle());
    }

    // 17
    // ok
    @Test
    public void detectTriangle_Rectangular_1_tst(){
        var tr = new Triangle(3, 4, 5);
        Assert.assertEquals(8, tr.detectTriangle());
    }

    // 18
    // ok
    @Test
    public void detectTriangle_Rectangular_2_tst(){
        var tr = new Triangle(13, 12, 5);
        Assert.assertEquals(8, tr.detectTriangle());
    }

    // 19
    // ошибка разработника!
    @Test
    public void detectTriangle_Rectangular_3_tst(){
        var tr = new Triangle(2, 5, 4);
        Assert.assertEquals(8, tr.detectTriangle());
    }

    // 20
    // ошибка в условии теста (detectTriangle() не возвращает 0)
    @Test
    public void detectTriangle_Equilateral_tst(){
        var tr = new Triangle(2.35, 2.35, 2.35);
        Assert.assertEquals(0, tr.detectTriangle());
    }

    // 21
    // некорректны и тест, и функция
    @Test
    public void detectTriangle_Isosceles_1_tst(){
        var tr = new Triangle(7,7,25);
        Assert.assertEquals(2, tr.detectTriangle());
    }

    // 22
    // некорректны и тест, и функция
    @Test
    public void detectTriangle_Isosceles_2_tst(){
        var tr = new Triangle(2.3, 14.3, 14.3);
        Assert.assertEquals(2, tr.detectTriangle());
    }

    // 23
    // некорректны и тест, и функция
    @Test
    public void detectTriangle_Isosceles_3_tst(){
        var tr = new Triangle(7.14,77,7.14);
        Assert.assertEquals(2,tr.detectTriangle());
    }

    // 24
    // ошибка в условии теста (detectTriangle() не возвращает 0)
    @Test
    public void detectTriangle_Isosceles_Rectangular_tst(){
        var tr = new Triangle(4.0,4.0, 4.0 * Math.sqrt(2.0));
        Assert.assertEquals(0, tr.detectTriangle());
    }

    // 25
    // выглядит хорошо
    @Test
    public void detectTriangle_Ordinary_tst(){
        var tr = new Triangle(1.12, 5.28, 5.23);
        Assert.assertEquals(4, tr.detectTriangle());
    }

    // 26
    // ok for good numbers
    @Test
    public void Square_Triangle_test(){
        double h = 3, b1 = 4, b2 = 12;
        double a = Math.sqrt(h*h + b1*b1), b = b1 + b2, c = Math.sqrt(h*h + b2*b2);

        double square = (h*b1 + h*b2) / 2;
        var tr = new Triangle(a,b,c);
        Assert.assertEquals(square, tr.getSquare(), 0.000001);
    }

    // 27
    // нет обработки некорректного ввода
    @Test
    public void Wrong_Triangle1(){
        var tr = new Triangle(7, 16, 2);
        boolean passed = false;
        try{
            tr.getSquare();
        }
        catch (Exception e){
            passed = true;
        }

        Assert.assertTrue(passed);
    }

    // 28
    // нет проверки на треугольник
    @Test
    public void Wrong_Triangle2(){
        var tr = new Triangle(2,16,3);
        Assert.assertTrue(Double.isNaN(tr.getSquare()));
    }

    // 29
    // нет обработки некорректного ввода
    @Test
    public void Wrong_triangle3(){
        var tr = new Triangle(7, -8, 4);
        boolean passed = false;
        try{
            tr.getSquare();
        }
        catch (Exception e){
            passed = true;
        }

        Assert.assertTrue(passed);
    }
}