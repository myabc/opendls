package org.opendls.model.util;

/**
 *
 * @author alexbcoles
 */
public class Matrix<T>
{
    T [][] data;

    public Matrix(int rows, int cols)
    {
        data = (T[][]) new Object[rows][cols];
    }

}
