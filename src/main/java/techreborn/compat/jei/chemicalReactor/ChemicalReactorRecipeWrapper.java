package techreborn.compat.jei.chemicalReactor;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import net.minecraft.client.Minecraft;
import techreborn.api.recipe.machines.ChemicalReactorRecipe;
import techreborn.client.gui.GuiChemicalReactor;
import techreborn.compat.jei.BaseRecipeWrapper;

public class ChemicalReactorRecipeWrapper extends BaseRecipeWrapper<ChemicalReactorRecipe>
{
	private final IDrawableAnimated progress;

	public ChemicalReactorRecipeWrapper(@Nonnull IJeiHelpers jeiHelpers, @Nonnull ChemicalReactorRecipe baseRecipe)
	{
		super(baseRecipe);
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		IDrawableStatic progressStatic = guiHelper.createDrawable(GuiChemicalReactor.texture, 176, 14, 32, 12);

		int ticksPerCycle = baseRecipe.tickTime();
		this.progress = guiHelper.createAnimatedDrawable(progressStatic, ticksPerCycle,
				IDrawableAnimated.StartDirection.TOP, false);
	}

	@Override
	public void drawAnimations(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight)
	{
		super.drawAnimations(minecraft, recipeWidth, recipeHeight);
		progress.draw(minecraft, 3, 18);
	}
}
