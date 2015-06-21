package mapwriter.config;

import mapwriter.gui.ModGuiConfig.ModBooleanEntry;
import mapwriter.util.Reference;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;

public class smallMapModeConfig extends largeMapModeConfig
{
	public smallMapModeConfig(String configCategory) 
	{
		super(configCategory);
	}
	
	@Override
	public void loadConfig()
	{
		super.loadConfig();
		this.heightPercent = ConfigurationHandler.configuration.getInt("heightPercent",this.configCategory, this.heightPercentDef, 0, 100, "mw.config.map.heightPercent");
		this.Position = ConfigurationHandler.configuration.getString("Position", this.configCategory, this.PositionDef, "mw.config.map.Position", miniMapPositionStringArray);
	}
	
	@Override
	public void setDefaults()
	{		
		this.rotateDef = true;
		this.circularDef = true;
		this.coordsModeDef = coordsModeStringArray[1];	
		this.borderModeDef = true;
		this.playerArrowSizeDef = 4;
		this.markerSizeDef = 3;
		this.heightPercentDef = 30;
		this.PositionDef = MapModeConfig.miniMapPositionStringArray[0];

		ConfigurationHandler.configuration.get(Reference.catSmallMapConfig, "enabled", this.enabledDef).setRequiresWorldRestart(true);
	}
}
