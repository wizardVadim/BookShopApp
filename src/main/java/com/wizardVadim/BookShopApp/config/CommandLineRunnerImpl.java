package com.wizardVadim.BookShopApp.config;

import com.wizardVadim.BookShopApp.data.test.TestEntity;
import com.wizardVadim.BookShopApp.data.test.TestEntityCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    private TestEntityCrudRepository testEntityCrudRepository;

    @Autowired
    public CommandLineRunnerImpl(TestEntityCrudRepository testEntityCrudRepository) {
        this.testEntityCrudRepository = testEntityCrudRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//        for (int i=0; i<5; i++) {
//            createTestEntity(new TestEntity());
//        }
//
//        TestEntity readTestEntity = readTestEntityById(3L);
//        if (readTestEntity != null) {
//            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read " + readTestEntity.toString());
//        } else {
//            throw new NullPointerException();
//        }
////
//        TestEntity updatedTestEntity = updateTestEntityById(5L);
//        if (readTestEntity != null) {
//            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update " + updatedTestEntity.toString());
//        } else {
//            throw new NullPointerException();
//        }
//
//        deleteTestEntityByID(1L);
    }

    private void deleteTestEntityByID(Long id) {
        testEntityCrudRepository.delete(testEntityCrudRepository.findById(id).get());
    }

    private TestEntity updateTestEntityById(long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntity.setData("NEW DATA");
        testEntityCrudRepository.save(testEntity);
        return testEntity;
    }

    private TestEntity readTestEntityById(long id) {
        return testEntityCrudRepository.findById(id).get();
    }

    private void createTestEntity(TestEntity entity) {
        entity.setData(entity.getClass().getSimpleName() + entity.hashCode());
        testEntityCrudRepository.save(entity);
    }
}
