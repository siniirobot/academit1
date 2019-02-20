package ru.academItScholl.gorbunov.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.academItScholl.gorbunov.Tests.MatrixCreatingTest;
import ru.academItScholl.gorbunov.Tests.MatrixTestStatic;
import ru.academItScholl.gorbunov.Tests.MatrixTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        MatrixTestStatic.class,
        MatrixTest.class,
        MatrixCreatingTest.class
})

public class Realization {
}


