package visuals.bars;

import java.awt.*;

import main.ArrayVisualizer;
import utils.Highlights;
import utils.Renderer;
import visuals.Visual;

final public class BarGraph extends Visual {

    public BarGraph(ArrayVisualizer ArrayVisualizer) {
        super(ArrayVisualizer);
    }

    @Override
    public void drawVisual(int[] array, ArrayVisualizer ArrayVisualizer, Renderer Renderer, Highlights Highlights) {
        for(int i = 0, j = 0; i < Renderer.getArrayLength(); i++) {
			if(Highlights.fancyFinishActive() && i < Highlights.getFancyFinishPosition())
				this.mainRender.setColor(Color.GREEN);
			
			else if(ArrayVisualizer.colorEnabled()) {
				int val = ArrayVisualizer.doingStabilityCheck() && ArrayVisualizer.colorEnabled() ? ArrayVisualizer.getIndexValue(array[i]): array[i];
				this.mainRender.setColor(getIntColor(val, ArrayVisualizer.getCurrentLength()));
			}
			else this.mainRender.setColor(Color.WHITE);
			
            int width = (int) (Renderer.getXScale() * (i + 1)) - j;
			
			if(width > 0) {
				int val = ArrayVisualizer.doingStabilityCheck() && ArrayVisualizer.colorEnabled() ? ArrayVisualizer.getStabilityValue(array[i]): array[i];
				int y = (int) (((Renderer.getViewSize() - 20)) - (val + 1) * Renderer.getYScale());
				
				this.mainRender.fillRect(j + 20, Renderer.getYOffset() + y, width, (int) ((val + 1) * Renderer.getYScale()));

				if (width >= 15 && ArrayVisualizer.barsStrokeEnabled()) {
					double thickness = 1;
					Stroke oldStroke = this.mainRender.getStroke();
					this.mainRender.setStroke(new BasicStroke((float) thickness));
					this.mainRender.setColor(Color.BLACK);
					this.mainRender.drawLine(j + 20, Renderer.getYOffset() + y, j + 20, (int) ((array[i] + 1) * Renderer.getYScale())+Renderer.getYOffset() + y);
					this.mainRender.setStroke(oldStroke);
				}

			}
			j += width;
        }
		this.mainRender.setColor(ArrayVisualizer.getHighlightColor());
		
		for(int i = 0, j = 0; i < Renderer.getArrayLength(); i++) {
			int width = (int) (Renderer.getXScale() * (i + 1)) - j;
			
			if(Highlights.containsPosition(i)) {
				int val = ArrayVisualizer.doingStabilityCheck() && ArrayVisualizer.colorEnabled() ? ArrayVisualizer.getStabilityValue(array[i]): array[i];
				int y = (int) (((Renderer.getViewSize() - 20)) - (val + 1) * Renderer.getYScale());
				
				this.mainRender.fillRect(j + 20, Renderer.getYOffset() + y, Math.max(width, 2), (int) ((val + 1) * Renderer.getYScale()));
			}
			j += width;
		}
		if(ArrayVisualizer.externalArraysEnabled()) {
			this.mainRender.setColor(Color.BLUE);
			this.mainRender.fillRect(0, Renderer.getYOffset() + Renderer.getViewSize() - 20, ArrayVisualizer.currentWidth(), 1);
		}
    }
}