package com.mbf;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "More Bank Fillers"
)
public class MoreFillPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MoreFillOverlay overlay;


	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}


	@Provides
	MoreFillConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MoreFillConfig.class);
	}


}
