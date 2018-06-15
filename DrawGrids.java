package gridExample;
import java.awt.*;
import java.awt.event.*;


public class DrawGrids extends Frame {
    DrawGrids(String title, int w, int h, int rows, int columns) {
      setTitle(title);
      Grids grid = new Grids(rows, columns);
      add(grid);
    }
  }