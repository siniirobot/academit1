package ru.academItScholl.gorbunov.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.academItScholl.gorbunov.Tests.MatrixArray.MatrixArrayTest;
import ru.academItScholl.gorbunov.Tests.MatrixCopyTest.MatrixCopyTest;
import ru.academItScholl.gorbunov.Tests.MatrixInt.MatrixIntTest;
import ru.academItScholl.gorbunov.Tests.MatrixTestStaticFunc;
import ru.academItScholl.gorbunov.Tests.MatrixVector.MatrixVectorTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        MatrixTestStaticFunc.class,
        MatrixArrayTest.class,
        MatrixCopyTest.class,
        MatrixIntTest.class,
        MatrixVectorTest.class
})

public class Realization {
}


