/**
 * Copyright (c) 2014 Richard Warburton (richard.warburton@gmail.com)
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 **/
package com.insightfullogic.honest_profiler.ports.javafx.flame_graph;

import com.insightfullogic.honest_profiler.core.collector.FlameGraph;
import com.insightfullogic.honest_profiler.ports.sources.FileLogSource;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

import static com.insightfullogic.honest_profiler.core.collector.FlameGraphCollector.readFlamegraph;

public class FlameGraphExample extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Honest Profiler");
        stage.setWidth(1920);
        stage.setHeight(1000);

        FlameGraph data = readFlamegraph(new FileLogSource(new File("log-10401-1439827661223.hpl")));
        Group root = new Group();
        FlameGraphView flameGraphView = new FlameGraphView(stage);
        flameGraphView.setWidth(1920);
        flameGraphView.setHeight(1000);
        root.getChildren().add(flameGraphView);
        stage.setScene(new Scene(root));
        stage.show();

        flameGraphView.display(data);

    }

    @Override
    public void stop() throws Exception
    {
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
