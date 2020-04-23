package application.data.persistance.dto.builders;


import application.data.persistance.dto.RecipeDto;

public class RecipeDtoBuilder {
	private final RecipeDto recipeDto;

	public RecipeDtoBuilder() {
		recipeDto = new RecipeDto();
	}

	public RecipeDtoBuilder title(String title) {
		recipeDto.setTitle(title);
		return this;
	}

	public RecipeDtoBuilder image(String image) {
		recipeDto.setImage(image);
		return this;
	}

	public RecipeDtoBuilder cookingTime(String cookingTime) {
		recipeDto.setCookingTime(cookingTime);
		return this;
	}

	public RecipeDtoBuilder portionAmount(String portionAmount) {
		recipeDto.setPortionAmount(portionAmount);
		return this;
	}

	public RecipeDtoBuilder description(String description) {
		recipeDto.setDescription(description);
		return this;
	}

	public RecipeDtoBuilder advice(String advice) {
		recipeDto.setAdvice(advice);
		return this;
	}

	public RecipeDto build() {
		return recipeDto;
	}
}
