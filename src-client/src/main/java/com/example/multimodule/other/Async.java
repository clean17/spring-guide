package com.example.multimodule.other;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * 어노테이션 없이 비동기
 */
public class Async {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);


    // 방법 1 executor
    public void scheduleMethod() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            // 실행하려는 코드
        }, 1, TimeUnit.SECONDS);
        executor.shutdown();
    }

    /////////////////////////////////////////////////////////////////////

    public String someMethod2() {
        asyncMethod();  // 비동기로 메서드 실행
        return "Some Result";  // 결과 반환
    }

    private void asyncMethod2() {
        executor.submit(() -> {
            // 비동기로 실행할 로직
            System.out.println("Executing async method");
        });
    }

    //////////////////////////////////////////////////////////////////////

    // 방법 2 CompletableFuture
    public String someMethod() {
        CompletableFuture.runAsync(this::asyncMethod);  // 비동기로 메서드 실행
        return "Some Result";  // 결과 반환
    }

    private void asyncMethod() {
        // 비동기로 실행할 로직
        System.out.println("Executing async method");
    }
}
