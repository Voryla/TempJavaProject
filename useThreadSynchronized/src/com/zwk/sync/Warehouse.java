package com.zwk.sync;

/**
 * 仓库
 */
public class Warehouse {
    int count = 0;
    NotebookPC[] notebookPCS = new NotebookPC[10];

    public synchronized void push(NotebookPC notebookPC) {
        if (count == notebookPCS.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notebookPCS[count] = notebookPC;
        count++;
        this.notify();
    }

    public synchronized NotebookPC takeOut() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        this.notify();
        return notebookPCS[count];
    }
}
